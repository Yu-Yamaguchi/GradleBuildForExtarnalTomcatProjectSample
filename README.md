Gradleを使って外部プロジェクトのビルド・テストを実行するサンプル
====

##Overview
様々な大人の事情により、JavaによるWebアプリケーション開発を、Eclipseの**「Tomcatプロジェクト」**で開発しなければならないとしましょう。
Gradleプロジェクトにはしちゃいけないんです＞＜

そこで、もう1つGradleのプロジェクトを作成し、大人の事情で作ったTomcatプロジェクトを外部参照して、Gradleからテストを実行したり、Findbugsを動かしたりできないかなぁと考えてみました。
（Gradleでテスト実行できると、美しいテストレポートなどが出せるので）

そのサンプルです。

> **おそらく**

> - TomcatProject内部にテストコードを書かずに、TomcatProjectGradle側にテストコードを記述することができたかもしれない。（今回のケースでは、テストコードをTomcatProject内に作成することが制約上OKだったので上記構成となっている。）

###List

* 外部に設置されたプロジェクトに対するBuild
* JUnitの結果レポート出力
* FindBugsのレポート出力（HTML対応）
* jacocoによるカバレッジレポート出力（HTML対応）

## Usage

> コマンドプロンプトからカレントディレクトリをTomcatProjectGradleに変更して実行してください。
>
> CI用に全てのタスクを適切な順序で実行する。
> > `gradlew  clean  ci`
> > このタスクでは、以下のタスクが順番に全て実行されます。
> > * clean … 全てのタスク実行前にクリーンする。
> > * findbugs … findbugsはcheckタスクの依存関係に標準でセットされているため、check実行時に、先行して実行される。
> > * testAll … check.dependsOn += testAllで依存関係をセットしているため、check実行時に、先行して実行される。
> > * check … checkstyleの実行
> > * checkstyleReport … check実行結果のxmlからHTMLのレポートを出力
> > * jacoco … jacocoによるコードカバレッジレポートをHTML形式で出力
>
> 上記以外に、個別にタスクを実行したい場合は以下のような利用方法を試してください。
>
> 指定したテストスィートのJUnitを実行する。
> > `gradlew testAllTests`
>
> FindBugsを実行する。
> > `gradlew findbugsTest`
>
> Checkstyleを実行する→実行後にCheckstyleのレポートを出力する。
> > `gradlew check`
> > `gradlew checkstyleReport`
>
> jacocoによるカバレッジレポートを出力する。
> > `gradlew jacoco`
 

##LISENCE

MIT

## Author
[Yu-Yamaguchi](https://github.com/Yu-Yamaguchi)
