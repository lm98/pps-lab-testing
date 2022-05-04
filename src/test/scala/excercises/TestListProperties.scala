package excercises

import org.scalacheck.Prop.forAll
import org.scalacheck.{Gen, Properties}

class TestListProperties extends Properties("List"):
  property("Concat is associative") = forAll { (xs: List[Unit], ys: List[Unit], zs: List[Unit]) =>
    (xs ++ ys) ++ zs == xs ++ (ys ++ zs)
  }

  property("Array and list concat results in a List") = forAll { (xs: List[Unit]) =>
    xs ++ Array[Unit]() == xs
  }

  property("Mapping with Identity returns the same List") = forAll { (xs: List[Unit]) =>
    xs.map(identity) == xs
  }

  property("Composition") = forAll { (xs: List[Int], f: Int => Int, g: Int => Int) =>
    xs.map(f compose g) == xs.map(g).map(f)
  }

class TestPalindromes extends Properties("String"):
  val palindromeGen: Gen[String] =
    for
      s <- Gen.alphaStr
      c <- Gen.alphaChar
    yield s + c + s.reverse

  property("Palindromeness") = forAll(palindromeGen) { (s: String) =>
    s == s.reverse
  }