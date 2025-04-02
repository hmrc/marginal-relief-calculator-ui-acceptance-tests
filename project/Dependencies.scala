import sbt._

object Dependencies {

  val test = Seq(
    "uk.gov.hmrc"         %% "ui-test-runner"  % "0.45.0",
    "org.scalatestplus"   %% "selenium-4-17"   % "3.2.18.0",
    "io.cucumber"         %% "cucumber-scala"  % "8.25.1",
    "io.cucumber"          % "cucumber-junit"  % "7.19.0",
    "org.scalatest"       %% "scalatest"       % "3.2.18",
    "com.typesafe"         % "config"          % "1.4.3",
    "org.playframework"    %% "play-test"      % "3.0.5" exclude("ch.qos.logback", "logback-classic")
  )

}
