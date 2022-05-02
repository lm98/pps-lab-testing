package excercises

import org.scalacheck.Prop.forAll
import org.scalacheck.Properties

class TestListProperties extends Properties("List"):
  property("Concat is associative") = forAll { (xs: List[Unit], ys: List[Unit], zs: List[Unit]) =>
    (xs ++ ys) ++ zs == xs ++ (ys ++ zs)
  }

  property("Array and list concat results in a List") = forAll { (xs: List[Unit]) =>
    xs ++ Array[Unit]() == xs
  }
