plugins {
  java
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("io.vertx:vertx-core:3.6.3")
  implementation("ch.qos.logback:logback-classic:1.2.3")
  testCompile("org.junit.jupiter:junit-jupiter-api:5.4.0")
  testCompile("io.vertx:vertx-junit5:3.6.3")
  testRuntime("org.junit.jupiter:junit-jupiter-engine:5.4.0")
}

tasks.create<JavaExec>("run") {
  main = project.properties.getOrDefault("mainClass", "chapter3.local.Main") as String
  classpath = sourceSets["main"].runtimeClasspath
  systemProperties["vertx.logger-delegate-factory-class-name"] = "io.vertx.core.logging.SLF4JLogDelegateFactory"
}

tasks.named<Test>("test") {
  useJUnitPlatform()
}

java {
  sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks.wrapper {
  gradleVersion = "5.2.1"
}
