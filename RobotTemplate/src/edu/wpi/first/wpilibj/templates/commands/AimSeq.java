
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author bradmiller
 */
public class AimSeq extends CommandGroup {

    public AimSeq() {
        addParallel(new AimV());
        addParallel(new AimH());
        addParallel(new SpinUpShooter());
    }

}
