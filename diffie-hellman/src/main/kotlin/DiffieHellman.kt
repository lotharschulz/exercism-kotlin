import java.math.BigInteger
import java.security.SecureRandom

object DiffieHellman {

    fun privateKey(prime: BigInteger): BigInteger =
        BigInteger.valueOf(SecureRandom().nextLong(2, prime.toLong()))

    fun publicKey(p: BigInteger, g: BigInteger, privKey: BigInteger): BigInteger =
        g.modPow(privKey, p)

    fun secret(prime: BigInteger, publicKey: BigInteger, privateKey: BigInteger): BigInteger =
        publicKey.modPow(privateKey, prime)

}
