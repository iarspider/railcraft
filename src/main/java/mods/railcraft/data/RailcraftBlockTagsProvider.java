package mods.railcraft.data;

import mods.railcraft.Railcraft;
import mods.railcraft.tags.RailcraftTags;
import mods.railcraft.world.level.block.RailcraftBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class RailcraftBlockTagsProvider extends BlockTagsProvider {

  public RailcraftBlockTagsProvider(DataGenerator generator, ExistingFileHelper fileHelper) {
    super(generator, Railcraft.ID, fileHelper);
  }

  @Override
  protected void addTags() {
    this.tag(RailcraftTags.Blocks.BALLAST)
        .addTag(Tags.Blocks.GRAVEL);
    this.tag(RailcraftTags.Blocks.SWITCH_TRACK_ACTUATOR)
        .add(RailcraftBlocks.SWITCH_TRACK_LEVER.get())
        .add(RailcraftBlocks.SWITCH_TRACK_MOTOR.get());
    this.tag(BlockTags.RAILS)
        .add(RailcraftBlocks.FORCE_TRACK.get(),
            RailcraftBlocks.ABANDONED_TRACK.get(),
            RailcraftBlocks.ABANDONED_LOCKING_TRACK.get(),
            RailcraftBlocks.ABANDONED_ACTIVATOR_TRACK.get(),
            RailcraftBlocks.ABANDONED_BOOSTER_TRACK.get(),
            RailcraftBlocks.ABANDONED_CONTROL_TRACK.get(),
            RailcraftBlocks.ABANDONED_GATED_TRACK.get(),
            RailcraftBlocks.ABANDONED_DETECTOR_TRACK.get(),
            RailcraftBlocks.ABANDONED_COUPLER_TRACK.get(),
            RailcraftBlocks.ABANDONED_EMBARKING_TRACK.get(),
            RailcraftBlocks.ABANDONED_DISEMBARKING_TRACK.get(),
            RailcraftBlocks.ABANDONED_TURNOUT_TRACK.get(),
            RailcraftBlocks.ABANDONED_WYE_TRACK.get(),
            RailcraftBlocks.ABANDONED_JUNCTION_TRACK.get(),
            RailcraftBlocks.ABANDONED_LAUNCHER_TRACK.get(),
            RailcraftBlocks.ABANDONED_ONE_WAY_TRACK.get(),
            RailcraftBlocks.ABANDONED_LOCOMOTIVE_TRACK.get(),
            RailcraftBlocks.ELECTRIC_TRACK.get(),
            RailcraftBlocks.ELECTRIC_LOCKING_TRACK.get(),
            RailcraftBlocks.ELECTRIC_ACTIVATOR_TRACK.get(),
            RailcraftBlocks.ELECTRIC_BOOSTER_TRACK.get(),
            RailcraftBlocks.ELECTRIC_CONTROL_TRACK.get(),
            RailcraftBlocks.ELECTRIC_GATED_TRACK.get(),
            RailcraftBlocks.ELECTRIC_DETECTOR_TRACK.get(),
            RailcraftBlocks.ELECTRIC_COUPLER_TRACK.get(),
            RailcraftBlocks.ELECTRIC_EMBARKING_TRACK.get(),
            RailcraftBlocks.ELECTRIC_DISEMBARKING_TRACK.get(),
            RailcraftBlocks.ELECTRIC_TURNOUT_TRACK.get(),
            RailcraftBlocks.ELECTRIC_WYE_TRACK.get(),
            RailcraftBlocks.ELECTRIC_JUNCTION_TRACK.get(),
            RailcraftBlocks.ELECTRIC_LAUNCHER_TRACK.get(),
            RailcraftBlocks.ELECTRIC_ONE_WAY_TRACK.get(),
            RailcraftBlocks.ELECTRIC_LOCOMOTIVE_TRACK.get(),
            RailcraftBlocks.HIGH_SPEED_TRACK.get(),
            RailcraftBlocks.HIGH_SPEED_TRANSITION_TRACK.get(),
            RailcraftBlocks.HIGH_SPEED_LOCKING_TRACK.get(),
            RailcraftBlocks.HIGH_SPEED_ACTIVATOR_TRACK.get(),
            RailcraftBlocks.HIGH_SPEED_BOOSTER_TRACK.get(),
            RailcraftBlocks.HIGH_SPEED_DETECTOR_TRACK.get(),
            RailcraftBlocks.HIGH_SPEED_TURNOUT_TRACK.get(),
            RailcraftBlocks.HIGH_SPEED_WYE_TRACK.get(),
            RailcraftBlocks.HIGH_SPEED_JUNCTION_TRACK.get(),
            RailcraftBlocks.HIGH_SPEED_LOCOMOTIVE_TRACK.get(),
            RailcraftBlocks.HIGH_SPEED_ELECTRIC_TRACK.get(),
            RailcraftBlocks.HIGH_SPEED_ELECTRIC_TRANSITION_TRACK.get(),
            RailcraftBlocks.HIGH_SPEED_ELECTRIC_LOCKING_TRACK.get(),
            RailcraftBlocks.HIGH_SPEED_ELECTRIC_ACTIVATOR_TRACK.get(),
            RailcraftBlocks.HIGH_SPEED_ELECTRIC_BOOSTER_TRACK.get(),
            RailcraftBlocks.HIGH_SPEED_ELECTRIC_DETECTOR_TRACK.get(),
            RailcraftBlocks.HIGH_SPEED_ELECTRIC_TURNOUT_TRACK.get(),
            RailcraftBlocks.HIGH_SPEED_ELECTRIC_WYE_TRACK.get(),
            RailcraftBlocks.HIGH_SPEED_ELECTRIC_JUNCTION_TRACK.get(),
            RailcraftBlocks.HIGH_SPEED_ELECTRIC_LOCOMOTIVE_TRACK.get(),
            RailcraftBlocks.IRON_LOCKING_TRACK.get(),
            RailcraftBlocks.IRON_ACTIVATOR_TRACK.get(),
            RailcraftBlocks.IRON_BOOSTER_TRACK.get(),
            RailcraftBlocks.IRON_CONTROL_TRACK.get(),
            RailcraftBlocks.IRON_GATED_TRACK.get(),
            RailcraftBlocks.IRON_DETECTOR_TRACK.get(),
            RailcraftBlocks.IRON_COUPLER_TRACK.get(),
            RailcraftBlocks.IRON_EMBARKING_TRACK.get(),
            RailcraftBlocks.IRON_DISEMBARKING_TRACK.get(),
            RailcraftBlocks.IRON_TURNOUT_TRACK.get(),
            RailcraftBlocks.IRON_WYE_TRACK.get(),
            RailcraftBlocks.IRON_JUNCTION_TRACK.get(),
            RailcraftBlocks.IRON_LAUNCHER_TRACK.get(),
            RailcraftBlocks.IRON_ONE_WAY_TRACK.get(),
            RailcraftBlocks.IRON_LOCOMOTIVE_TRACK.get(),
            RailcraftBlocks.REINFORCED_TRACK.get(),
            RailcraftBlocks.REINFORCED_LOCKING_TRACK.get(),
            RailcraftBlocks.REINFORCED_ACTIVATOR_TRACK.get(),
            RailcraftBlocks.REINFORCED_BOOSTER_TRACK.get(),
            RailcraftBlocks.REINFORCED_CONTROL_TRACK.get(),
            RailcraftBlocks.REINFORCED_GATED_TRACK.get(),
            RailcraftBlocks.REINFORCED_DETECTOR_TRACK.get(),
            RailcraftBlocks.REINFORCED_COUPLER_TRACK.get(),
            RailcraftBlocks.REINFORCED_EMBARKING_TRACK.get(),
            RailcraftBlocks.REINFORCED_DISEMBARKING_TRACK.get(),
            RailcraftBlocks.REINFORCED_TURNOUT_TRACK.get(),
            RailcraftBlocks.REINFORCED_WYE_TRACK.get(),
            RailcraftBlocks.REINFORCED_JUNCTION_TRACK.get(),
            RailcraftBlocks.REINFORCED_LAUNCHER_TRACK.get(),
            RailcraftBlocks.REINFORCED_ONE_WAY_TRACK.get(),
            RailcraftBlocks.REINFORCED_LOCOMOTIVE_TRACK.get(),
            RailcraftBlocks.STRAP_IRON_TRACK.get(),
            RailcraftBlocks.STRAP_IRON_LOCKING_TRACK.get(),
            RailcraftBlocks.STRAP_IRON_ACTIVATOR_TRACK.get(),
            RailcraftBlocks.STRAP_IRON_BOOSTER_TRACK.get(),
            RailcraftBlocks.STRAP_IRON_CONTROL_TRACK.get(),
            RailcraftBlocks.STRAP_IRON_GATED_TRACK.get(),
            RailcraftBlocks.STRAP_IRON_DETECTOR_TRACK.get(),
            RailcraftBlocks.STRAP_IRON_COUPLER_TRACK.get(),
            RailcraftBlocks.STRAP_IRON_EMBARKING_TRACK.get(),
            RailcraftBlocks.STRAP_IRON_DISEMBARKING_TRACK.get(),
            RailcraftBlocks.STRAP_IRON_TURNOUT_TRACK.get(),
            RailcraftBlocks.STRAP_IRON_WYE_TRACK.get(),
            RailcraftBlocks.STRAP_IRON_JUNCTION_TRACK.get(),
            RailcraftBlocks.STRAP_IRON_LAUNCHER_TRACK.get(),
            RailcraftBlocks.STRAP_IRON_ONE_WAY_TRACK.get(),
            RailcraftBlocks.STRAP_IRON_LOCOMOTIVE_TRACK.get());
    this.tag(BlockTags.CLIMBABLE).add(RailcraftBlocks.ELEVATOR_TRACK.get());
    this.tag(RailcraftTags.Blocks.ASPECT_EMITTER)
        .add(RailcraftBlocks.SIGNAL_CAPACITOR_BOX.get(),
            RailcraftBlocks.SIGNAL_RECEIVER_BOX.get(),
            RailcraftBlocks.BLOCK_SIGNAL_RELAY_BOX.get(),
            RailcraftBlocks.SIGNAL_SEQUENCER_BOX.get());
    this.tag(RailcraftTags.Blocks.ASPECT_RECEIVER)
        .add(RailcraftBlocks.SIGNAL_CAPACITOR_BOX.get(),
            RailcraftBlocks.SIGNAL_CONTROLLER_BOX.get(),
            RailcraftBlocks.SIGNAL_INTERLOCK_BOX.get(),
            RailcraftBlocks.SIGNAL_SEQUENCER_BOX.get());

    RailcraftBlocks.POST.resolveVariants().forEach(this.tag(RailcraftTags.Blocks.POST)::add);

    this.tag(RailcraftTags.Blocks.SIGNAL)
        .add(RailcraftBlocks.BLOCK_SIGNAL.get(), RailcraftBlocks.DISTANT_SIGNAL.get(),
            RailcraftBlocks.TOKEN_SIGNAL.get(), RailcraftBlocks.DUAL_BLOCK_SIGNAL.get(),
            RailcraftBlocks.DUAL_DISTANT_SIGNAL.get(), RailcraftBlocks.DUAL_TOKEN_SIGNAL.get());
    this.tag(RailcraftTags.Blocks.MINEABLE_WITH_CROWBAR)
        .add(RailcraftBlocks.SWITCH_TRACK_LEVER.get(), RailcraftBlocks.SWITCH_TRACK_MOTOR.get(),
            RailcraftBlocks.ANALOG_SIGNAL_CONTROLLER_BOX.get(),
            RailcraftBlocks.SIGNAL_SEQUENCER_BOX.get(), RailcraftBlocks.SIGNAL_CAPACITOR_BOX.get(),
            RailcraftBlocks.SIGNAL_INTERLOCK_BOX.get(),
            RailcraftBlocks.BLOCK_SIGNAL_RELAY_BOX.get(), RailcraftBlocks.SIGNAL_RECEIVER_BOX.get(),
            RailcraftBlocks.SIGNAL_CONTROLLER_BOX.get(), RailcraftBlocks.DUAL_BLOCK_SIGNAL.get(),
            RailcraftBlocks.DUAL_DISTANT_SIGNAL.get(), RailcraftBlocks.DUAL_TOKEN_SIGNAL.get(),
            RailcraftBlocks.BLOCK_SIGNAL.get(), RailcraftBlocks.DISTANT_SIGNAL.get(),
            RailcraftBlocks.TOKEN_SIGNAL.get(), RailcraftBlocks.ELEVATOR_TRACK.get())
        .addTag(BlockTags.RAILS);

    var mineableWithPickaxe = this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
        .add(RailcraftBlocks.FIRESTONE.get())
        .add(RailcraftBlocks.LOW_PRESSURE_STEAM_BOILER_TANK.get())
        .add(RailcraftBlocks.HIGH_PRESSURE_STEAM_BOILER_TANK.get())
        .add(RailcraftBlocks.SOLID_FUELED_FIREBOX.get())
        .add(RailcraftBlocks.FLUID_FUELED_FIREBOX.get())
        .add(RailcraftBlocks.STEAM_TURBINE.get())
        .add(RailcraftBlocks.COKE_OVEN_BRICKS.get())
        .add(RailcraftBlocks.BLAST_FURNACE_BRICKS.get())
        .add(RailcraftBlocks.CRUSHER.get())
        .add(RailcraftBlocks.COKE_BLOCK.get())
        .add(RailcraftBlocks.CRUSHED_OBSIDIAN.get())
        .add(RailcraftBlocks.STEEL_BLOCK.get())
        .add(RailcraftBlocks.BRASS_BLOCK.get())
        .add(RailcraftBlocks.BRONZE_BLOCK.get())
        .add(RailcraftBlocks.INVAR_BLOCK.get())
        .add(RailcraftBlocks.LEAD_BLOCK.get())
        .add(RailcraftBlocks.NICKEL_BLOCK.get())
        .add(RailcraftBlocks.SILVER_BLOCK.get())
        .add(RailcraftBlocks.TIN_BLOCK.get())
        .add(RailcraftBlocks.ZINC_BLOCK.get());

    RailcraftBlocks.IRON_TANK_VALVE.resolveVariants().forEach(mineableWithPickaxe::add);
    RailcraftBlocks.IRON_TANK_WALL.resolveVariants().forEach(mineableWithPickaxe::add);
    RailcraftBlocks.STEEL_TANK_VALVE.resolveVariants().forEach(mineableWithPickaxe::add);
    RailcraftBlocks.STEEL_TANK_WALL.resolveVariants().forEach(mineableWithPickaxe::add);


    this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
        .add(RailcraftBlocks.FIRESTONE.get())
        .add(RailcraftBlocks.CRUSHED_OBSIDIAN.get());

    this.tag(BlockTags.NEEDS_IRON_TOOL)
        .add(RailcraftBlocks.STEEL_BLOCK.get())
        .add(RailcraftBlocks.BRASS_BLOCK.get())
        .add(RailcraftBlocks.BRONZE_BLOCK.get())
        .add(RailcraftBlocks.INVAR_BLOCK.get())
        .add(RailcraftBlocks.LEAD_BLOCK.get())
        .add(RailcraftBlocks.NICKEL_BLOCK.get())
        .add(RailcraftBlocks.SILVER_BLOCK.get())
        .add(RailcraftBlocks.TIN_BLOCK.get())
        .add(RailcraftBlocks.ZINC_BLOCK.get());

    var stoneToolAppender = this.tag(BlockTags.NEEDS_STONE_TOOL)
        .add(RailcraftBlocks.LOW_PRESSURE_STEAM_BOILER_TANK.get(),
            RailcraftBlocks.HIGH_PRESSURE_STEAM_BOILER_TANK.get(),
            RailcraftBlocks.FLUID_FUELED_FIREBOX.get(),
            RailcraftBlocks.STEAM_TURBINE.get())
        .add(RailcraftBlocks.COKE_BLOCK.get())
        .add(RailcraftBlocks.CRUSHER.get());

    RailcraftBlocks.IRON_TANK_VALVE.resolveVariants().forEach(stoneToolAppender::add);
    RailcraftBlocks.IRON_TANK_WALL.resolveVariants().forEach(stoneToolAppender::add);
    RailcraftBlocks.STEEL_TANK_VALVE.resolveVariants().forEach(stoneToolAppender::add);
    RailcraftBlocks.STEEL_TANK_WALL.resolveVariants().forEach(stoneToolAppender::add);

    this.tag(BlockTags.ANVIL)
        .add(RailcraftBlocks.STEEL_ANVIL.get(),
            RailcraftBlocks.CHIPPED_STEEL_ANVIL.get(),
            RailcraftBlocks.DAMAGED_STEEL_ANVIL.get());

    RailcraftBlocks.IRON_TANK_GAUGE.resolveVariants()
        .forEach(this.tag(RailcraftTags.Blocks.IRON_TANK_GAUGE)::add);

    RailcraftBlocks.IRON_TANK_VALVE.resolveVariants()
        .forEach(this.tag(RailcraftTags.Blocks.IRON_TANK_VALVE)::add);

    RailcraftBlocks.IRON_TANK_WALL.resolveVariants()
        .forEach(this.tag(RailcraftTags.Blocks.IRON_TANK_WALL)::add);

    RailcraftBlocks.STEEL_TANK_GAUGE.resolveVariants()
        .forEach(this.tag(RailcraftTags.Blocks.STEEL_TANK_GAUGE)::add);

    RailcraftBlocks.STEEL_TANK_VALVE.resolveVariants()
        .forEach(this.tag(RailcraftTags.Blocks.STEEL_TANK_VALVE)::add);

    RailcraftBlocks.STEEL_TANK_WALL.resolveVariants()
        .forEach(this.tag(RailcraftTags.Blocks.STEEL_TANK_WALL)::add);
  }

  @Override
  public String getName() {
    return "Railcraft Block Tags";
  }
}
