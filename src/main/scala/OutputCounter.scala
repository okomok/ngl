

// Copyright Shunsuke Sogame 2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package ngl


/**
 * Counts calls of <code>Seq.update</code>.
 */
final class OutputCounter(val from: Int) extends Seq[Any] with Output[Any] {
    /**
     * Starts from count <code>0</code>.
     */
    def this() = this(0)

    private[this] var c = from

    /**
     * Increments counter.
     */
    override protected def output(x: Any) = c += 1

    /**
     * Returns the result of counting.
     */
    def count: Int = c
}
