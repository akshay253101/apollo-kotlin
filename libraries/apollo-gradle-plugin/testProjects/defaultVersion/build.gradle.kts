plugins {
  alias(libs.plugins.kotlin.jvm)
  alias(libs.plugins.apollo)
}

dependencies {
  // Version comes from the plugin
  add("implementation", "com.apollographql.apollo3:apollo-runtime")
}

apollo {
  packageNamesFromFilePaths()
}