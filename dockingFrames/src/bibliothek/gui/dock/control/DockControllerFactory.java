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
package bibliothek.gui.dock.control;

import bibliothek.gui.DockController;
import bibliothek.gui.Dockable;
import bibliothek.gui.dock.action.ActionOffer;
import bibliothek.gui.dock.action.DockAction;
import bibliothek.gui.dock.action.view.ActionViewConverter;
import bibliothek.gui.dock.event.DockRegisterListener;

/**
 * Contains various factory methods which are used during initialization
 * of a {@link DockController}
 * @author Benjamin Sigg
 *
 */
public interface DockControllerFactory {
    /**
     * Creates a new register for the controller.
     * @param controller the controller for which the element is created
     * @return the new register
     */
    public DockRegister createRegister( DockController controller );
    
    /**
     * Creates a new relocator for the controller.
     * @param controller the controller for which the element is created
     * @return the relocator
     */
    public DockRelocator createRelocator( DockController controller );
    
    /**
     * Creates a listener which will observe all stations to ensure that
     * the focused {@link Dockable} is always visible.
     * @param controller the controller for which the element is created
     * @return the listener or <code>null</code>
     */
    public DockRegisterListener createFocusController( DockController controller );
    
    /**
     * Creates a listener which will open a popup-menu for each title
     * or dockable known to the controller.
     * @param controller the controller for which the element is created
     * @return the new listener or <code>null</code>
     */
    public DockRegisterListener createPopupController( DockController controller );
    
    /**
     * Creates a listener that will ensure that every {@link DockAction} is
     * bound to its {@link Dockable}.
     * @param controller the controller for which the element is created
     * @return the new listener or <code>null</code>
     */
    public DockRegisterListener createActionBinder( DockController controller );
    
    /**
     * Creates the focus-controller of the controller.
     * @param controller the controller for which the element is created
     * @return the controller, not <code>null</code>
     */
    public MouseFocusObserver createMouseFocusObserver( DockController controller );
    
    /**
     * Creates the controller that will forward double clicks with the mouse.
     * @param controller the controller for which the element is created
     * @return the controller, not <code>null</code>
     */
    public DoubleClickController createDoubleClickController( DockController controller );
    
    /**
     * Creates a new controller for global KeyEvents.
     * @param controller the controller for which the element is created
     * @return the new controller, not <code>null</code>
     */
    public KeyboardController createKeyboardController( DockController controller );

    /**
     * Creates the converter that will transform actions into views.
     * @param controller the controller for which the element is created
     * @return the new converter, not <code>null</code>
     */
    public ActionViewConverter createActionViewConverter( DockController controller );

    /**
     * Creates the default action offer. This {@link ActionOffer} will
     * be used if no other offer was interested in a Dockable.
     * @param controller the controller for which the element is created
     * @return the offer, must not be <code>null</code>
     */
    public ActionOffer createDefaultActionOffer( DockController controller );

    /**
     * Creates a {@link SingleParentRemover} that will be used to remove
     * some stations from this controller.
     * @param controller the controller for which the element is created
     * @return The remover
     * @see DockController#setSingleParentRemove(boolean)
     */
    public SingleParentRemover createSingleParentRemover( DockController controller );
}
