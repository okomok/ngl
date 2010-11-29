

// Copyright Shunsuke Sogame 2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package ngltest


import com.github.okomok.ngl


class CopyTest extends org.scalatest.junit.JUnit3Suite {

    def testCopy {
        val string = "ABCD"
        val result = new Array[Char](23)
        val _string = ngl.Seq.from(string)
        val _result = ngl.Seq.from(result)
        ngl.copy(_string, _string.begin, _string.end)(_result, _result.begin)
        expect('A')(result(0))
        expect('B')(result(1))
        expect('C')(result(2))
        expect('D')(result(3))
    }

    def testCopyBack {
        val numbers = Array(1,2,3,4,5)
        val result = new Array[Int](5)
        val _numbers = ngl.Seq.from(numbers)
        val _result = ngl.Seq.from(result)
        ngl.copy_backward(_numbers, _numbers.begin, _numbers.end)(_result, _result.end)
        expect(numbers(0))(result(0))
        expect(numbers(1))(result(1))
        expect(numbers(2))(result(2))
        expect(numbers(3))(result(3))
        expect(numbers(4))(result(4))
    }

    def testCopyVariance {
        val string = "ABCD"
        val result = new Array[Any](23)
        val _string = ngl.Seq.from(string)
        val _result = ngl.Seq.from(result)
        ngl.copy(_string, _string.begin, _string.end)(_result, _result.begin)
        expect('A')(result(0))
        expect('B')(result(1))
        expect('C')(result(2))
        expect('D')(result(3))
    }

    def testCopyBackVariance {
        val numbers = Array(1,2,3,4,5)
        val result = new Array[Any](5)
        val _numbers = ngl.Seq.from(numbers)
        val _result = ngl.Seq.from(result)
        ngl.copy_backward(_numbers, _numbers.begin, _numbers.end)(_result, _result.end)
        expect(numbers(0))(result(0))
        expect(numbers(1))(result(1))
        expect(numbers(2))(result(2))
        expect(numbers(3))(result(3))
        expect(numbers(4))(result(4))
    }

    def testCopyIf {
        val string = "ABCD"
        val result = new Array[Char](2)
        val _string = ngl.Seq.from(string)
        val _result = ngl.Seq.from(result)
        ngl.copy_if(_string, _string.begin, _string.end)(_result, _result.begin) { x =>
            x == 'A' || x == 'D'
        }
        expect('A')(result(0))
        expect('D')(result(1))
    }
}