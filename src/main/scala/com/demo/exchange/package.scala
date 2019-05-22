package com.demo

package object exchange {

  case class ExchangeId(id: String)
  case class OurId(id: String)

  sealed trait Side
  object Side {
    case object Bid extends Side
    case object Ask extends Side
  }

  sealed trait Message

  case class MarketData(currencyPair: CurrencyPair, bids: Seq[PriceLevel], asks: Seq[PriceLevel]) extends Message

  case class MarketReport(orderId: OurId, exchangeId: ExchangeId, filledBase: Quantity, rate: Rate) extends Message

  case class AvailableFunds(funds: Seq[Quantity]) extends Message

}
