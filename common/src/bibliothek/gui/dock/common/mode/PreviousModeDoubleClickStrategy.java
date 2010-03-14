/*
 * Bibliothek - DockingFrames
 * Library built on Java/Swing, allows the user to "drag and drop"
 * panels containing any Swing-Component the developer likes to add.
 * 
 * Copyright (C) 2010 Benjamin Sigg
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
package bibliothek.gui.dock.common.mode;

import bibliothek.gui.Dockable;
import bibliothek.gui.dock.facile.mode.DoubleClickLocationStrategy;
import bibliothek.gui.dock.facile.mode.status.ExtendedModeEnablement;

/**
 * If the current mode is {@link ExtendedMode#MAXIMIZED}, then this strategy asks
 * the {@link CLocationModeManager} for the last mode a {@link Dockable} was in and 
 * selects this mode. Otherwise {@link ExtendedMode#MAXIMIZED} is selected.
 * @author Benjamin Sigg
 */
public class PreviousModeDoubleClickStrategy implements DoubleClickLocationStrategy{
	/** the manager to ask for the previous mode */
	private CLocationModeManager manager;
	
	/**
	 * Creates a new strategy
	 * @param manager the manager to ask for the previous mode, not <code>null</code>
	 */
	public PreviousModeDoubleClickStrategy( CLocationModeManager manager ){
		this.manager = manager;
	}
	
	public ExtendedMode handleDoubleClick( Dockable dockable, ExtendedMode current, ExtendedModeEnablement enablement ){
		if( current != ExtendedMode.MAXIMIZED ){
			return ExtendedMode.MAXIMIZED;
		}
		else{
			CLocationMode mode = manager.getPreviousMode( dockable );
			if( mode == null )
				return ExtendedMode.NORMALIZED;
			ExtendedMode next = mode.getExtendedMode();
			if( !enablement.isAvailable( dockable, next ))
				return ExtendedMode.NORMALIZED;
			return next;
		}
	}
}