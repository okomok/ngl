

// Copyright Shunsuke Sogame 2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package ngl


private class OutputBy[A](f: A => Unit) extends Seq[A] with Output[A] {
    override protected def output(x: A) = f(x)
}
