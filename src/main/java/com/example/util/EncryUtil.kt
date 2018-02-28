import com.example.util.DES


/**
 * 加密解密工具类
 */
object EncryUtil {

    /**
     * 使用默认密钥进行DES加密
     */
    fun encrypt(plainText: String): String? {
        try {
            return DES().encrypt(plainText)
        } catch (e: Exception) {
            return null
        }

    }


    /**
     * 使用指定密钥进行DES解密
     */
    fun encrypt(plainText: String, key: String): String? {
        try {
            return DES(key).encrypt(plainText)
        } catch (e: Exception) {
            return null
        }

    }


    /**
     * 使用默认密钥进行DES解密
     */
    fun decrypt(plainText: String): String? {
        try {
            return DES().decrypt(plainText)
        } catch (e: Exception) {
            return null
        }

    }


    /**
     * 使用指定密钥进行DES解密
     */
    fun decrypt(plainText: String, key: String): String? {
        try {
            return DES(key).decrypt(plainText)
        } catch (e: Exception) {
            return null
        }

    }

}

fun main(args: Array<String>) {
    val source = "test"
    val encrypt = EncryUtil.encrypt(source, "123456")
    println(encrypt)
    val decrypt = EncryUtil.decrypt(encrypt ?: "", "123456")
    println(decrypt)
}