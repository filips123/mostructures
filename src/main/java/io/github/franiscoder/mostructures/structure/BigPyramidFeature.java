package io.github.franiscoder.mostructures.structure;

import io.github.franiscoder.mostructures.generator.BigPyramidGenerator;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.VillageStructureStart;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

public class BigPyramidFeature extends StructureFeature<DefaultFeatureConfig> {
    public BigPyramidFeature() {
        super(DefaultFeatureConfig.CODEC);
    }

    @Override
    public StructureStartFactory<DefaultFeatureConfig> getStructureStartFactory() {
        return BigPyramidFeature.Start::new;
    }

    public static class Start extends VillageStructureStart<DefaultFeatureConfig> {
        public Start(StructureFeature<DefaultFeatureConfig> feature, int chunkX, int chunkZ, BlockBox box, int references, long seed) {
            super(feature, chunkX, chunkZ, box, references, seed);
        }

        @Override
        public void init(ChunkGenerator chunkGenerator, StructureManager structureManager, int x, int z, Biome biome, DefaultFeatureConfig featureConfig) {
            BigPyramidGenerator.addPieces(chunkGenerator, structureManager, new BlockPos(x << 4, 0, z << 4), children, random);
            this.setBoundingBoxFromChildren();
        }
    }
}