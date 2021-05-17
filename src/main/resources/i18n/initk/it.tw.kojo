/* -*- mode: scala -*- */
/*
 * Copyright (C) 2013 
 *   Massimo Ghisalberti <zairik@gmail.com>,
 *   Lalit Pant <pant.lalit@gmail.com>
 *
 * The contents of this file are subject to the GNU General Public License
 * Version 3 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of
 * the License at http://www.gnu.org/copyleft/gpl.html
 *
 * Software distributed under the License is distributed on an "AS
 * IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * rights and limitations under the License.
 *
 */

//Italian Turtle wrapper init for Kojo

//make Italian names visible
val ItalianAPI = net.kogics.kojo.lite.i18n.ItalianAPI
import net.kogics.kojo.lite.i18n.ItalianCustomStatements._
import net.kogics.kojo.lite.i18n.ItalianDirectionCases._
import net.kogics.kojo.lite.i18n.ItalianSpeedCases._
import ItalianAPI.{
  Tartaruga,
  tartaruga,
  pulisci,
  pulisciOutput,
  blu,
  rosso,
  giallo,
  verde,
  porpora,
  rosa,
  marrone,
  nero,
  bianco,
  senzaColore,
  sfondo,
  gradiente,
  ripeti,
  ripetizione,
  ripetiPerOgniElementoDi,
  ripetiFinché,
  leggiLinea,
  scriviLinea,
  arrotonda,
  numeroCasuale,
  numeroDecimaleCasuale,
  nuovaTartaruga,
  conta,
  systemtid
}

import tartaruga.{pulisci => _, _}
