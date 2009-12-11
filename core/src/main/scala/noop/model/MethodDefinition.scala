/**
 *  Copyright 2009 Google Inc.
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

import collection.jcl.Buffer
import proto.Noop.{Modifier, Property, Method};

/**
 * Represents the declaration of a method in source code.
 *
 * @author alexeagle@google.com (Alex Eagle)
 * @author tocman@gmail.com (Jeremie Lenfant-Engelmann)
 */
class MethodDefinition(val data: Method)  {
  def name:String = data.getSignature.getName;
  def parameters: Seq[Property] = Buffer(data.getSignature.getArgumentList);
  def modifiers: Seq[Modifier] = Buffer(data.getSignature.getModifierList);
  def block: Block = new Block(data.getBlock);

  override def toString() = String.format("Method %s (%s) returns %s",
    data.getSignature.getName, data.getSignature.getArgumentList, data.getSignature.getReturnTypeList);
}
