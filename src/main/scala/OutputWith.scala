

// Copyright Shunsuke Sogame 2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package gine


object OutputBy {
    def apply[A](f: A => Unit): Seq[A] = new OutputBy(f)
}

private
class OutputBy[A](f: A => Unit) extends OutputSeq[A] {
    override def output(e: A) = f(e)
}
