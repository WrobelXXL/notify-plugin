import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.shadow)
    `maven-publish`
}

allprojects {
    group = "app.simplecloud.plugin.notify"
    version = "0.0.1-EXPERIMENTAL"

    repositories {
        mavenCentral()
        maven("https://buf.build/gen/maven")
        maven("https://repo.simplecloud.app/snapshots")
        maven("https://repo.papermc.io/repository/maven-public/")
    }
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "com.gradleup.shadow")
    apply(plugin = "maven-publish")

    dependencies {
        testImplementation(rootProject.libs.kotlin.test)
        implementation(rootProject.libs.kotlin.jvm)
    }

    publishing {
        publications {
            create<MavenPublication>("mavenJava") {
                from(components["java"])
            }
        }
    }

    java {
        toolchain.languageVersion.set(JavaLanguageVersion.of(21))
    }

    kotlin {
        jvmToolchain(21)
        compilerOptions {
            apiVersion.set(org.jetbrains.kotlin.gradle.dsl.KotlinVersion.KOTLIN_2_0)
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21)
        }
    }

    tasks.named("shadowJar", ShadowJar::class) {
        dependsOn("processResources")
        dependencies {
            include(project(":notify-shared"))
            /**
             * TODO: Add dependencies ADDED BY YOU like this:
             * include(dependency(libs.your.dependency.get()))
             */
        }
        archiveFileName.set("${project.name}.jar")
    }

    tasks.test {
        useJUnitPlatform()
    }

    tasks.processResources {
        expand(
            "version" to project.version,
            "name" to project.name
        )
    }
}