

// Copyright Shunsuke Sogame 2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok


package object ngl {

    /**
     * @return  <code>java.lang.Math.MIN_INT</code>, which is the reserved index.
     */
    final val SINGULAR = 0x80000000

    def toArray[A : ClassManifest](v: Seq[A]): Array[A] = {
        val a = new Array[A](v.end - v.begin)
        val ^ = Seq.from(a)
        copy(v, v.begin, v.end)(^, ^.begin)
        a
    }

    def toJList[A](v: Seq[A]): java.util.List[A] = {
        val a = new java.util.ArrayList[A](v.end - v.begin)
        for_each(v, v.begin, v.end) { x =>
            a.add(x)
        }
        a
    }

    def accumulate[A, B](v: Seq[A], first: Int, last: Int)(init: B)(binary_op: (B, A) => B): B = Accumulate(v, first, last, init, binary_op)

    def adjacent_find[A](v: Seq[A], first: Int, last: Int): Int = AdjacentFind(v, first, last)
    def adjacent_find_if[A](v: Seq[A], first: Int, last: Int)(binary_pred: (A, A) => Boolean): Int = AdjacentFind(v, first, last, binary_pred)

    def lower_bound[A](v: Seq[A], first: Int, last: Int)(value: A)(implicit c: Ordering[A]): Int = LowerBound(v, first, last, value, c)
    def upper_bound[A](v: Seq[A], first: Int, last: Int)(value: A)(implicit c: Ordering[A]): Int = UpperBound(v, first, last, value, c)

    def copy[A](v : Seq[A], first: Int, last: Int)(^ : Seq[_ >: A], result: Int): Int = Copy(v, first, last, ^, result)
    def copy_if[A](v : Seq[A], first: Int, last: Int)(^ : Seq[_ >: A], result: Int)(pred: A => Boolean): Int = CopyIf(v, first, last, ^, result, pred)

    def copy_backward[A](v : Seq[A], first: Int, last: Int)(^ : Seq[_ >: A], result: Int): Int = CopyBackward(v, first, last, ^, result)

    def count(v: Seq[_], first: Int, last: Int)(x: Any): Int = Count(v, first, last, x)
    def count_if[A](v: Seq[A], first: Int, last: Int)(pred: A => Boolean): Int = CountIf(v, first, last, pred)

    def inner_product[A](v1: Seq[A], first1: Int, last1: Int)(v2: Seq[A], first2: Int)(Init: A)(binary_op1: (A, A) => A)(binary_op2: (A, A) => A): A = InnerProduct(v1, first1, last1, v2, first2, Init, binary_op1, binary_op2)

    def min_element[A](v: Seq[A], first: Int, last: Int)(implicit c: Ordering[A]): Int = MinElement(v, first, last, c)
    def max_element[A](v: Seq[A], first: Int, last: Int)(implicit c: Ordering[A]): Int = MaxElement(v, first, last, c)

    def median[A](x: A, y: A, z: A)(implicit c: Ordering[A]): A = Median(x, y, z, c)

    def equal(v1: Seq[_], first1: Int, last1: Int)(v2: Seq[_], first2: Int): Boolean = Equal(v1, first1, last1, v2, first2)
    def equal_if[A1, A2](v1: Seq[A1], first1: Int, last1: Int)(v2: Seq[A2], first2: Int)(binary_pred: (A1, A2) => Boolean): Boolean = Equal(v1, first1, last1, v2, first2, binary_pred)
    def mismatch(v1: Seq[_], first1: Int, last1: Int)(v2: Seq[_], first2: Int): (Int, Int) = Mismatch(v1, first1, last1, v2, first2)
    def mismatch_if[A1, A2](v1: Seq[A1], first1: Int, last1: Int)(v2: Seq[A2], first2: Int)(binary_pred: (A1, A2) => Boolean): (Int, Int) = Mismatch(v1, first1, last1, v2, first2, binary_pred)

    def fill[A](v: Seq[A], first: Int, last: Int)(value: A): Unit = Fill(v, first, last, value)
    def fill_n[A](v: Seq[A], first: Int)(n: Int)(value: A): Int = FillN(v, first, n, value)

    def find(v: Seq[_], first: Int, last: Int)(value: Any): Int = Find(v, first, last, value)
    def find_if[A](v: Seq[A], first: Int, last: Int)(pred: A => Boolean): Int = FindIf(v, first, last, pred)

    def for_each[A](v: Seq[A], first: Int, last: Int)(f: A => Any): Unit = ForEach(v, first, last, f)

    def generate[A](v: Seq[A], first: Int, last: Int)(gen: Function0[A]): Unit = Generate(v, first, last, gen)
    def generate_n[A](v: Seq[A], first: Int)(n: Int)(gen: Function0[A]): Unit = GenerateN(v, first, n, gen)

    def includes[A](v1: Seq[A], first1: Int, last1: Int)(v2: Seq[A], first2: Int, last2: Int)(implicit c: Ordering[A]): Boolean = Includes(v1, first1, last1, v2, first2, last2, c)

    def lexicographical_compare[A](v1: Seq[A], first1: Int, last1: Int)(v2: Seq[A], first2: Int, last2: Int)(implicit c: Ordering[A]): Boolean = LexicographicalCompare(v1, first1, last1, v2, first2, last2, c)
    def lexicographical_compare_3way[A](v1: Seq[A], first1: Int, last1: Int)(v2: Seq[A], first2: Int, last2: Int)(implicit c: Ordering[A]): Int = LexicographicalCompare3way(v1, first1, last1, v2, first2, last2, c)

    def merge[A](v1 : Seq[A], first1: Int, last1: Int)(v2 : Seq[A], first2: Int, last2: Int)(^ : Seq[A], result: Int)(implicit c: Ordering[A]): Int = Merge(v1, first1, last1, v2, first2, last2, ^, result, c)

    def nth_element[A](v: Seq[A], first: Int, nth: Int, last: Int)(implicit c: Ordering[A]): Unit = NthElement(v, first, nth, last, c)

    def partial_sort[A](v: Seq[A], first: Int, middle: Int, last: Int)(implicit c: Ordering[A]): Unit = PartialSort(v, first, middle, last, c)

    def partial_sum[A](v : Seq[A], first: Int, last: Int)(^ : Seq[_ >: A], result: Int)(binary_op: (A, A) => A): Int = PartialSum(v, first, last, ^, result, binary_op)

    def push_heap[A](v: Seq[A], first: Int, last: Int)(implicit c: Ordering[A]): Unit = PushHeap(v, first, last, c)
    def pop_heap[A](v: Seq[A], first: Int, last: Int)(implicit c: Ordering[A]): Unit = PopHeap(v, first, last, c)
    def make_heap[A](v: Seq[A], first: Int, last: Int)(implicit c: Ordering[A]): Unit = MakeHeap(v, first, last, c)
    def sort_heap[A](v: Seq[A], first: Int, last: Int)(implicit c: Ordering[A]): Unit = SortHeap(v, first, last, c)
    def is_heap[A](v: Seq[A], first: Int, last: Int)(implicit c: Ordering[A]): Boolean = IsHeap(v, first, last, c)

    def iter_swap[A](v1: Seq[A], i1: Int)(v2: Seq[A], i2: Int): Unit = IterSwap(v1, i1, v2, i2)

    def random_shuffle(v: Seq[_], first: Int, last: Int): Unit = RandomShuffle(v, first, last)
    def random_shuffle_by(v: Seq[_], first: Int, last: Int)(rand: Int => Int): Unit = RandomShuffle(v, first, last, rand)

    def random_sample[A](v : Seq[A], first: Int, last: Int)(^ : Seq[_ >: A], out_first: Int, out_last: Int): Int = RandomSample(v, first, last, ^, out_first, out_last)
    def random_sample_by[A](v : Seq[A], first: Int, last: Int)(^ : Seq[_ >: A], out_first: Int, out_last: Int)(rand: Int => Int): Int = RandomSample(v, first, last, ^, out_first, out_last, rand)

    def random_sample_n[A](v : Seq[A], first: Int, last: Int)(^ : Seq[_ >: A], out_ite: Int, n: Int): Int = RandomSampleN(v, first, last, ^, out_ite, n)
    def random_sample_n_by[A](v : Seq[A], first: Int, last: Int)(^ : Seq[_ >: A], out_ite: Int, n: Int)(rand: Int => Int): Int = RandomSampleN(v, first, last, ^, out_ite, n, rand)

    def remove(v: Seq[_], first: Int, last: Int)(x: Any): Int = Remove(v, first, last, x)
    def remove_if[A](v: Seq[A], first: Int, last: Int)(pred: A => Boolean): Int = RemoveIf(v, first, last, pred)

    def remove_copy[A](v : Seq[A], first: Int, last: Int)(^ : Seq[_ >: A], result: Int)(x: Any): Int = RemoveCopy(v, first, last, ^, result, x)
    def remove_copy_if[A](v : Seq[A], first: Int, last: Int)(^ : Seq[_ >: A], result: Int)(pred: A => Boolean): Int = RemoveCopyIf(v, first, last, ^, result, pred)

    def replace[A](v: Seq[A], first: Int, last: Int)(old_value: Any, new_value: A): Unit = Replace(v, first, last, old_value, new_value)
    def replace_if[A](v: Seq[A], first: Int, last: Int)(new_value: A)(pred: A => Boolean): Unit = ReplaceIf(v, first, last, pred, new_value)

    def replace_copy[A](v : Seq[A], first: Int, last: Int)(^ : Seq[_ >: A], result: Int)(old_value: Any, new_value: A): Int = ReplaceCopy(v, first, last, ^, result, old_value, new_value)
    def replace_copy_if[A](v : Seq[A], first: Int, last: Int)(^ : Seq[_ >: A], result: Int)(new_value: A)(pred: A => Boolean): Int = ReplaceCopyIf(v, first, last, ^, result, pred, new_value)

    def reverse(v: Seq[_], first: Int, last: Int): Unit = Reverse(v, first, last)
    def reverse_copy[A](v : Seq[A], first: Int, last: Int)(^ : Seq[_ >: A], result: Int): Int = ReverseCopy(v, first, last, ^, result)

    def sort[A](v: Seq[A], first: Int, last: Int)(implicit c: Ordering[A]): Unit = Sort(v, first, last, c)
    def stable_sort[A](v: Seq[A], first: Int, last: Int)(implicit c: Ordering[A]): Unit = StableSort(v, first, last, c)
    def is_sorted[A](v: Seq[A], first: Int, last: Int)(implicit c: Ordering[A]): Boolean = IsSorted(v, first, last, c)

    def swap_ranges[A](v1: Seq[A], first1: Int, last1: Int)(v2: Seq[A], first2: Int): Int = SwapRanges(v1, first1, last1, v2, first2)

    def transform[A, B](v : Seq[A], first: Int, last: Int)(^ : Seq[B], result: Int)(opr: A => B): Int = Transform(v, first, last, ^, result, opr)
    def transform_zip[A, B, C](v1 : Seq[A], first1: Int, last1: Int)(v2 : Seq[B], first2: Int)(^ : Seq[C], result: Int)(binary_op: (A, B) => C): Int = Transform(v1, first1, last1, v2, first2, ^, result, binary_op)

    def unique(v: Seq[_], first: Int, last: Int): Int = Unique(v, first, last)
    def unique_if[A](v: Seq[A], first: Int, last: Int)(binary_pred: (A, A) => Boolean): Int = Unique(v, first, last, binary_pred)

    def unique_copy[A](v : Seq[A], first: Int, last: Int)(^ : Seq[_ >: A], result: Int): Int = UniqueCopy(v, first, last, ^, result)
    def unique_copy_if[A, B >: A](v : Seq[A], first: Int, last: Int)(^ : Seq[B], result: Int)(binary_pred: (A, B) => Boolean): Int = UniqueCopy(v, first, last, ^, result, binary_pred)

    /**
     * Creates <code>Seq</code> in which <code>update</code> calls <code>f</code>.
     */
    def output_by[A](f: A => Unit): Seq[A] = new OutputBy(f)

}
