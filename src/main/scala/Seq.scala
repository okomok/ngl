

// Copyright Shunsuke Sogame 2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package gine


import scala.annotation.unchecked.uncheckedVariance


trait Seq[+A] extends PartialFunction[Int, A] { self =>

    /**
     * @return  begin index, which is NOT guaranteed to be <code>0</code>.
     */
    def begin: Int

    /**
     * @return  end index, which is NOT guaranteed to be <code>size</code>.
     */
    def end: Int

    /**
     * @param   i   index of element to return.
     * @return  the element at the specified index.
     * @throws  NotReadableException if not overridden.
     */
    @Annotation.pre("readable")
    @Annotation.pre("`isDefinedAt(i)`")
    override def apply(i: Int): A = throw new NotReadableException(this)

    /**
     * Replaces the element at the specified index with
     * the specified element.
     *
     * @param   i   index of element to replace.
     * @param   e   element to be stored at the specified position.
     * @throws  NotWritableException if not overridden.
     */
    @Annotation.pre("writable")
    @Annotation.pre("`isDefinedAt(i)`")
    def update(i: Int, x: A @uncheckedVariance): Unit = throw new NotWritableException(this)

    /**
     * @return  <code>(begin <= i) && (i < end)</code>, possibly overridden in subclasses.
     */
    override def isDefinedAt(i: Int): Boolean = (begin <= i) && (i < end)

}
