package test

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.spec.IsolationMode

class ProjectConfig : AbstractProjectConfig() {
    override val parallelism: Int = Runtime.getRuntime().availableProcessors()
    override val isolationMode: IsolationMode = IsolationMode.InstancePerLeaf
}
