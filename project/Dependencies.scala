import sbt._

object Dependencies {

  val test = Seq(
    "uk.gov.hmrc"       %% "ui-test-runner" % "0.52.0",
    "org.scalatestplus" %% "selenium-4-17"  % "3.2.18.0",
    "org.scalatest"     %% "scalatest"      % "3.2.19",
    "com.typesafe"       % "config"         % "1.4.5",
    "org.playframework" %% "play-test"      % "3.0.10" exclude ("ch.qos.logback", "logback-classic")
  )

}
