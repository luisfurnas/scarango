package com.outr.arango.query.dsl

import com.outr.arango.query._
import com.outr.arango.{Document, DocumentModel, DocumentRef, FieldAndValue}

case class UpdatePart[D <: Document[D], Model <: DocumentModel[D]](ref: DocumentRef[D, Model], values: List[FieldAndValue[_]]) {
  def build(): Query = {
    val context = QueryBuilderContext()
    val name = context.name(ref)
    val fields = values.flatMap { fv =>
      List[QueryPart](", ", fv.field, ": ", fv.value)
    }.tail
    val parts: List[QueryPart] = List[QueryPart](
      "UPDATE ", name, " WITH {"
    ) ::: fields ::: List[QueryPart](
      "} IN ", ref.collectionName
    )

    Query(parts)
  }
}