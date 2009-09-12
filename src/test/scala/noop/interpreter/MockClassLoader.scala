package noop.interpreter;

import grammar.Parser;
import scala.collection.mutable;
import model.ClassDefinition;

/**
 * @author alexeagle@google.com (Alex Eagle)
 * @author jeremiele@google.com (Jeremie Lenfant-Engelmann)
 */
class MockClassLoader(p: Parser, s: List[String]) extends ClassLoader(p, s) {
  val classes = mutable.Map.empty[String, ClassDefinition];

  def this() = this(null, List());

  override def findClass(className: String): ClassDefinition = {
    return classes(className);
  }
}