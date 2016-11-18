/**
 * Copyright [2016] Gaurav Gupta
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
package org.netbeans.jpa.modeler.properties.rootmember.nodes;

import java.util.List;
import org.netbeans.jpa.modeler.core.widget.JavaClassWidget;
import org.netbeans.jpa.modeler.navigator.nodes.CheckableAttributeNode;
import org.netbeans.jpa.modeler.navigator.nodes.TreeChildFactory;
import org.netbeans.jpa.modeler.spec.EntityMappings;
import org.netbeans.jpa.modeler.spec.extend.JavaClass;
import org.netbeans.jpa.modeler.specification.model.scene.JPAModelerScene;
import org.openide.nodes.Children;
import org.openide.nodes.Node;

public class EntityManagerChildFactory extends TreeChildFactory<EntityMappings ,JavaClassWidget> {

    @Override
    protected boolean createKeys(List<JavaClassWidget> javaClassWidgets) {
        JPAModelerScene scene = null;
        if (parentNode instanceof RMRootNode) {
            scene = ((RMRootNode) parentNode).getRootWidget();
        }
        if (scene != null) {
            javaClassWidgets.addAll(scene.getJavaClassWidges());
        }
        return true;
    }

    @Override
    protected Node createNodeForKey(final JavaClassWidget javaClassWidget) {
        RMLeafNode childNode;
        CheckableAttributeNode checkableNode = new CheckableAttributeNode();
        JavaClass javaClass = (JavaClass) javaClassWidget.getBaseElementSpec();

        checkableNode.setSelected(javaClass.getGenerateSourceCode());

        childNode = new RMLeafNode(javaClassWidget, parentNode.getBaseElementSpec(), Children.LEAF, checkableNode);
        childNode.setParent(parentNode);
        parentNode.addChild(childNode);
        childNode.init();
        return (Node) childNode;
    }

}