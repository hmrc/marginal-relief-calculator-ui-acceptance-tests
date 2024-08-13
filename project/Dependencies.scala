import sbt._

object Dependencies {

  val test = Seq(
    "uk.gov.hmrc"         %% "ui-test-runner"  % "0.33.0"   % Test,
    "org.scalatestplus"   %% "selenium-4-17"    % "3.2.18.0" % Test,
    "io.cucumber"         %% "cucumber-scala"  % "8.23.0"   % Test,
    "io.cucumber"          % "cucumber-junit"  % "7.18.0"   % Test,
    "org.scalatest"       %% "scalatest"       % "3.2.18"   % Test,
    "junit"                % "junit"           % "4.13.2"   % Test,
    "com.github.sbt"       % "junit-interface" % "0.13.3"   % Test,
    "com.typesafe"         % "config"          % "1.4.3"    % Test
  )

}
