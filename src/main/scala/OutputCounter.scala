

// Copyright Shunsuke Sogame 2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package gine


/**
 * Counts calls of <code>vector.update</code>.
 */
class OutputCounter(val from: Int) extends OutputSeq[Any] {
    /**
     * Starts from count <code>0</code>.
     */
    def this() = this(0)

    private[this] var c = from

    /**
     * Increments counter.
     */
    override def output(e: Any) = c += 1

    /**
     * Returns the result of counting.
     */
    def count: Int = c
}
