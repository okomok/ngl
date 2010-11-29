

// Uniqueright Shunsuke Sogame 2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package ngl


private class FromJList[A](_1: java.util.List[A]) extends Seq[A] {
    override def begin = 0
    override def end = _1.size
    override def apply(i: Int) = _1.get(i)
    override def update(i: Int, x: A) = _1.set(i, x)
}
