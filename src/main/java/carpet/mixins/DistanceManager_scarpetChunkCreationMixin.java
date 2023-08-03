package carpet.mixins;

import java.util.Set;
import net.minecraft.server.level.ChunkHolder;
import net.minecraft.server.level.DistanceManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import carpet.fakes.DistanceManagerInterface;

@Mixin(DistanceManager.class)
public abstract class DistanceManager_scarpetChunkCreationMixin implements DistanceManagerInterface
{
    @Shadow
    @Final
    private Set<ChunkHolder> chunksToUpdateFutures;

    @Override
    public void carpet$replaceHolder(final ChunkHolder oldHolder, final ChunkHolder newHolder)
    {
        this.chunksToUpdateFutures.remove(oldHolder);
        this.chunksToUpdateFutures.add(newHolder);
    }
}
