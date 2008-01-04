package bibliothek.gui.dock.facile.intern;
/*
 * Bibliothek - DockingFrames
 * Library built on Java/Swing, allows the user to "drag and drop"
 * panels containing any Swing-Component the developer likes to add.
 * 
 * Copyright (C) 2007 Benjamin Sigg
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 * 
 * Benjamin Sigg
 * benjamin_sigg@gmx.ch
 * CH - Switzerland
 */
import bibliothek.gui.dock.DefaultDockable;
import bibliothek.gui.dock.action.DefaultDockActionSource;
import bibliothek.gui.dock.action.LocationHint;

/**
 * A default implementation of {@link FacileDockable}, based on a {@link DefaultDockable}.
 * @author Benjamin Sigg
 *
 */
public class DefaultFacileDockable extends DefaultDockable implements FacileDockable{
    /** the model */
    private FDockable dockable;
    
    /** the list of actions of this dockable */
    private DefaultDockActionSource actions;
    
    /**
     * Creates a new dockable
     * @param dockable the model of this element
     */
    public DefaultFacileDockable( FDockable dockable ){
        this.dockable = dockable;
        actions = new DefaultDockActionSource(
                new LocationHint( LocationHint.DOCKABLE, LocationHint.LEFT ));
        setActionOffers( actions );
    }
    
    public DefaultDockActionSource getActions() {
        return actions;
    }
    
    public FDockable getDockable(){
        return dockable;
    }
}
