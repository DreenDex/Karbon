kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":karbonpowered-api"))
                api(project(":karbonpowered-network"))
                api(project(":karbonpowered-nbt"))
            }
        }
    }
}