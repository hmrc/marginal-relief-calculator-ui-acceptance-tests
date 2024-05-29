import sbt._

object Dependencies {

  val test = Seq(
    "uk.gov.hmrc"         %% "ui-test-runner"  % "0.19.0"   % Test,
    "org.scalatestplus"   %% "selenium-4-2"    % "3.2.13.0" % Test,
    "io.cucumber"         %% "cucumber-scala"  % "8.20.0"   % Test,
    "io.cucumber"          % "cucumber-junit"  % "7.15.0"   % Test,
    "org.scalatest"       %% "scalatest"       % "3.2.18"   % Test,
    "junit"                % "junit"           % "4.13.2"   % Test,
    "com.novocode"         % "junit-interface" % "0.11"     % Test,
    "com.typesafe"         % "config"          % "1.4.3"    % Test
  )

}
