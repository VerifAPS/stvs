# Maintainer: csicat (gmail)
# Original Author: David Fuhr <david.fuhr@web.de>

pkgname=stvs-git
pkgver=1.2
pkgrel=1
pkgdesc="A graphical frontend for the verification of Structured Text code"
arch=('any')
url="https://github.com/VerifAPS/stvs"
license=("GPL")
depends=('java-runtime')
makedepends=('git' 'gradle')
source=("${pkgname}::git+${url}.git")

build() {
  cd $srcdir/$pkgname
  ls
  gradle dependencies
  gradle jar
}

package() {
  mkdir -p "$pkgdir/opt/"

  cp "$srcdir/stvs/build/libs/stverificationstudio-all.jar" "$pkgdir/opt/$pkgname/stverificationstudio.jar"

  chmod 755 "$pkgdir/opt/$pkgname/stverificationstudio.jar"

  #install -D -m0644 "$srcdir/ganttproject.desktop" "$pkgdir/usr/share/applications/ganttproject.desktop"
  #mkdir -p "$pkgdir/usr/bin"
  #ln -s "/opt/$pkgname/ganttproject" "$pkgdir/usr/bin/ganttproject"
}
sha256sums=('SKIP')
