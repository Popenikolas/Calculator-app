import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm") version "1.9.21"
    id("org.jetbrains.compose") version "1.6.0"
}

group = "com.example.calculator"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

dependencies {
    // Compose for Desktop UI Toolkit
    implementation(compose.desktop.currentOs)
    
    // Math parser library to evaluate expressions safely
    implementation("org.mariuszgromada.math:MathParser.org-mXparser:5.2.1")
}

compose.desktop {
    application {
        // The mainClass should point to the file containing your main() function.
        // The Kotlin compiler creates a class named after the file, e.g., Main.kt -> MainKt.
        mainClass = "com.example.calculator.MainActivityKt" 
        
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "KotlinCalculator"
            packageVersion = "1.0.0"
        }
    }
}
