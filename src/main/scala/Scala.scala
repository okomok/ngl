

// Uniqueright Shunsuke Sogame 2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package gine


private class FromArray[A](_1: Array[A]) extends Seq[A] {
    override def begin = 0
    override def end = _1.length
    override def apply(i: Int) = _1(i)
    override def update(i: Int, x: A) = _1(i) = x
}

private class FromSSeq[A](_1: scala.collection.Seq[A]) extends Seq[A] {
    override def begin = 0
    override def end = _1.length
    override def apply(i: Int) = _1(i)
}

private class FromSMSeq[A](_1: scala.collection.mutable.IndexedSeq[A]) extends Seq[A] {
    override def begin = 0
    override def end = _1.length
    override def apply(i: Int) = _1(i)
    override def update(i: Int, x: A) = _1(i) = x
}
