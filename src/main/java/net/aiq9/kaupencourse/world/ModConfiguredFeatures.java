package net.aiq9.kaupencourse.world;

import net.aiq9.kaupencourse.KaupenCourse121;
import net.aiq9.kaupencourse.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.CherryFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLACKWOOD_KEY = registerKey("blackwood");

    public static final RegistryKey<ConfiguredFeature<?, ?>> FLUORITE_ORE_KEY = registerKey("fluorite_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_FLUORITE_ORE_KEY = registerKey("nether_fluorite_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_FLUORITE_ORE_KEY = registerKey("end_fluorite_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> DAHLIA_KEY = registerKey("dahlia");

    public static final RegistryKey<ConfiguredFeature<?, ?>> FLUORITE_GEODE_KEY = registerKey("fluorite_geode");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        //TREE GEN
        register(context, BLACKWOOD_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                //trunk
                BlockStateProvider.of(ModBlocks.BLACKWOOD_LOG),
                new StraightTrunkPlacer(5, 6, 3),

                //leaves
                BlockStateProvider.of(ModBlocks.BLACKWOOD_LEAVES),
                new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(1), ConstantIntProvider.create(5), //radius' for leaves
                        0.25f, 0.5f, 0.15f, 0.05f),

                //remove dirtProvider() for vanilla behavior:
                //
                // .dirtProvider(BlockStateProvider.of(Blocks.END_STONE))
                new TwoLayersFeatureSize(1, 0, 2)).dirtProvider(BlockStateProvider.of(Blocks.END_STONE)).build());

        // ORE GEN (& Rule Test)
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworldFluoriteOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.FLUORITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_FLUORITE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> netherFluoriteOre =
                List.of(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.NETHER_FLUORITE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> endFluoriteOre =
                List.of(OreFeatureConfig.createTarget(endReplaceables, ModBlocks.END_FLUORITE_ORE.getDefaultState()));

        register(context, FLUORITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldFluoriteOres, 12));
        register(context, NETHER_FLUORITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherFluoriteOre, 10));
        register(context, END_FLUORITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(endFluoriteOre, 9));

        //DAHLIA FLOWER GEN
        register(context, DAHLIA_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.DAHLIA)))));

        //FLUORITE GEODE GEN
        register(context, FLUORITE_GEODE_KEY, Feature.GEODE, new GeodeFeatureConfig(new GeodeLayerConfig(BlockStateProvider.of(Blocks.AIR),
                BlockStateProvider.of(Blocks.DEEPSLATE),
                BlockStateProvider.of(ModBlocks.FLUORITE_ORE),
                BlockStateProvider.of(Blocks.DIRT),
                BlockStateProvider.of(Blocks.EMERALD_BLOCK),
                List.of(ModBlocks.FLUORITE_BLOCK.getDefaultState()),
                BlockTags.FEATURES_CANNOT_REPLACE , BlockTags.GEODE_INVALID_BLOCKS),
                new GeodeLayerThicknessConfig(1.7D, 1.2D, 2.5D, 3.5D),
                new GeodeCrackConfig(0.25D, 1.5D, 1),
                0.5D, 0.1D,
                true, UniformIntProvider.create(3, 8),
                UniformIntProvider.create(2, 6), UniformIntProvider.create(1, 2),
                -18, 18, 0.075D, 1));
    }

    //HELPER METHODS
    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(KaupenCourse121.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
