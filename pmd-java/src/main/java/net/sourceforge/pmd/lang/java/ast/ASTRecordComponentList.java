/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */


package net.sourceforge.pmd.lang.java.ast;

import net.sourceforge.pmd.annotation.Experimental;
import net.sourceforge.pmd.lang.java.ast.ASTList.ASTNonEmptyList;

/**
 * Defines the state description of a {@linkplain ASTRecordDeclaration RecordDeclaration} (JDK 14 preview feature).
 *
 * <pre class="grammar">
 *
 * RecordComponentList ::= "(" ( {@linkplain ASTRecordComponent RecordComponent} ( "," {@linkplain ASTRecordComponent RecordComponent} )* )? ")"
 *
 * </pre>
 */
@Experimental
public final class ASTRecordComponentList extends ASTNonEmptyList<ASTRecordComponent> {

    ASTRecordComponentList(int id) {
        super(id, ASTRecordComponent.class);
    }

    @Override
    public Object jjtAccept(JavaParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }

    @Override
    public <T> void jjtAccept(SideEffectingVisitor<T> visitor, T data) {
        visitor.visit(this, data);
    }
}