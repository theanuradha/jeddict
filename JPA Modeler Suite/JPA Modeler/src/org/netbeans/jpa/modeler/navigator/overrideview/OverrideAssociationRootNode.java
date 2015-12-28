/**
 * Copyright [2014] Gaurav Gupta
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.netbeans.jpa.modeler.navigator.overrideview;

import org.netbeans.jpa.modeler.core.widget.EntityWidget;
import org.netbeans.jpa.modeler.spec.Entity;
import org.netbeans.jpa.modeler.specification.model.util.JPAModelerUtil;
import org.netbeans.modeler.node.ModelerNavigationNode;
import org.openide.nodes.Children;

public class OverrideAssociationRootNode extends ModelerNavigationNode {

    public OverrideAssociationRootNode(EntityWidget entityWidget) {
        super(Children.create(new OverrideAssociationChildFactory(entityWidget), true));
        Entity entity = entityWidget.getBaseElementSpec();
        setDisplayName(entity.getClazz());
        setShortDescription(entity.getClazz());
        setIconBaseWithExtension(JPAModelerUtil.ENTITY_ICON_PATH);
    }
}
