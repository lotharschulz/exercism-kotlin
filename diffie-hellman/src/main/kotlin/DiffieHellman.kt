import java.math.BigInteger

object DiffieHellman {

    fun privateKey(prime: BigInteger): BigInteger {
        return 20.toBigInteger()
    }

    fun publicKey(p: BigInteger, g: BigInteger, privKey: BigInteger): BigInteger {
        TODO("Implement the function to complete the task")
    }

    fun secret(prime: BigInteger, publicKey: BigInteger, privateKey: BigInteger): BigInteger {
        TODO("Implement the function to complete the task")
    }
}
