
import io.kotlintest.inspectors.forAll
import io.kotlintest.specs.WordSpec


class RobotSpecificationTest : WordSpec() {

    init {

        "generate robot names" should {
            "return always a different name" {
                val rs = listOf(Robot())
                rs.forAll {
                    //it.shouldContain("_")
                    it.generateName() != it.generateName()
                }
            }
        }
    }
}