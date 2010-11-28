

// Copyright Shunsuke Sogame 2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package gine


/**
 * Mixin which supports only the <code>update</code> method, whose index argument is ignored.
 */
trait Output[A] { self: Seq[A] =>
    /**
     * Does something using <code>x</code>.
     */
    protected def output(x: A): Unit

    final override def begin = SINGULAR
    final override def end = SINGULAR
    final override def apply(i: Int) = throw new NotReadableException(self)

    @Annotation.equivalentTo("output(x)")
    final override def update(i: Int, x: A) = output(x)
}
