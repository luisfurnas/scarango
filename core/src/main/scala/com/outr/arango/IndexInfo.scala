package com.outr.arango

import fabric.rw.{ReaderWriter, ccRW}

case class IndexInfo(`type`: String,
                     id: String,
                     fields: Option[List[String]] = None,
                     unique: Option[Boolean] = None,
                     sparse: Option[Boolean] = None,
                     isNewlyCreated: Option[Boolean] = None,
                     selectivityEstimate: Option[Double] = None)

object IndexInfo {
  implicit val rw: ReaderWriter[IndexInfo] = ccRW
}