
@file:JvmName("HashingUtils")

package es.jaranda.poc.springbootkolindemo.utils

import es.jaranda.poc.springbootkolindemo.util.impl.Sha256HasherUtilImpl

fun Any.hashWithSha256() = Sha256HasherUtilImpl().hashSecret(this)
