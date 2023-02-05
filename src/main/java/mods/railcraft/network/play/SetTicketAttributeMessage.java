package mods.railcraft.network.play;

import java.util.function.Supplier;
import mods.railcraft.util.PlayerUtil;
import mods.railcraft.world.item.GoldenTicketItem;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.InteractionHand;
import net.minecraftforge.network.NetworkEvent;

public record SetTicketAttributeMessage(InteractionHand hand, String dest) {

  public void encode(FriendlyByteBuf out) {
    out.writeEnum(this.hand);
    out.writeUtf(dest);
  }

  public static SetTicketAttributeMessage decode(FriendlyByteBuf in) {
    return new SetTicketAttributeMessage(in.readEnum(InteractionHand.class), in.readUtf());
  }

  public boolean handle(Supplier<NetworkEvent.Context> context) {
    var player = context.get().getSender();
    var senderProfile = player.getGameProfile();

    var itemStackToUpdate = player.getItemInHand(this.hand);
    if (itemStackToUpdate.getItem() instanceof GoldenTicketItem) {
      var tag = itemStackToUpdate.getOrCreateTag().copy();
      PlayerUtil.writeOwnerToNBT(tag, senderProfile);
      tag.putString("dest", this.dest);
      itemStackToUpdate.setTag(tag);
    }
    return true;
  }
}
