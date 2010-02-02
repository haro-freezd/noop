/**
 * Copyright 2009 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package noop.model

import proto.NoopAst.Conditional;

/**
 * @author tocman@gmail.com (Jeremie Lenfant-Engelmann)
 */
class ConditionalAndExpression(val data: Conditional) extends Expression {
  def lhs = new ExpressionWrapper(data.getLhs)
  def rhs = new ExpressionWrapper(data.getRhs)

  def accept(visitor: Visitor) = {
    lhs.accept(visitor);
    visitor.visit(this);
    rhs.accept(visitor);
    visitor.visit(this);
  }
}
