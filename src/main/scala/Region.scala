

// Copyright Shunsuke Sogame 2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package ngl


case class Region[A](base: Seq[A], override val begin: Int, override val end: Int) extends Seq[A] {
    Pre.range(begin, end, "Region")

    override def apply(i: Int) = base.apply(i)
    override def update(i: Int, x: A) = base.update(i, x)
    override def isDefinedAt(i: Int) = base.isDefinedAt(i)

    override def apply(i: Int, j: Int): Seq[A] = { // apply.apply fusion
        if (i == begin && j == end) {
            this
        } else {
            base(i, j)
        }
    }
}
