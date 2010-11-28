

// Copyright Shunsuke Sogame 2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package gine


import scala.annotation.unchecked.uncheckedVariance


object Seq


trait Seq[+A] extends { self =>

    def begin: Int
    def end: Int

    def read(i: Int): A
    def write(i: Int, x: A @uncheckedVariance): Unit

    object deref {
        def apply(i: Int): A = self.read(i)
        def update(i: Int, x: A @uncheckedVariance): Unit = self.write(i, x)
    }

}
