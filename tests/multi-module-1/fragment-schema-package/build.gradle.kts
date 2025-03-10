plugins {
  id("org.jetbrains.kotlin.jvm")
  id("apollo.test")
  id("com.apollographql.apollo3")
}

dependencies {
  implementation(golatac.lib("apollo.runtime"))
  implementation(project(":multi-module-1:root"))
  apolloMetadata(project(":multi-module-1:root"))
  testImplementation(golatac.lib("kotlin.test.junit"))
}

apollo {
  packageNamesFromFilePaths()
  useSchemaPackageNameForFragments.set(true)
}
