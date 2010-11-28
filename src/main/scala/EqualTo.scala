

// Copyright Shunsuke Sogame 2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package gine


private object EqualTo extends Function2[Any, Any, Boolean] {
    override def apply(x: Any, y: Any) = x == y
}
